package dev.enjarai.trickster.screen.owo;

import dev.enjarai.trickster.Trickster;
import dev.enjarai.trickster.net.LoadExampleSpellPacket;
import dev.enjarai.trickster.net.ModNetworking;
import dev.enjarai.trickster.screen.SpellPartWidget;
import dev.enjarai.trickster.spell.SpellPart;
import io.wispforest.owo.ui.base.BaseComponent;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.core.OwoUIDrawContext;
import io.wispforest.owo.ui.core.ParentComponent;
import io.wispforest.owo.ui.core.Sizing;
import io.wispforest.owo.ui.parsing.UIModelParsingException;
import io.wispforest.owo.ui.parsing.UIParsing;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ConfirmScreen;
import net.minecraft.text.Text;
import org.w3c.dom.Element;

import static dev.enjarai.trickster.render.SpellCircleRenderer.*;
import static dev.enjarai.trickster.screen.SpellPartWidget.PRECISION_OFFSET;

public class SpellPreviewComponent extends BaseComponent {
    protected final SpellPart spell;
    protected final SpellPartWidget wrapped;

    public SpellPreviewComponent(SpellPart spell) {
        super();
        this.spell = spell;
        this.wrapped = new SpellPartWidget(
                spell, 0, 0, 24,
                s -> {
                }, s -> {
        }, () -> null,
                () -> {
                }
        );
        this.wrapped.setMutable(false);
        this.wrapped.renderer.setColor(0.2f, 0.2f, 0.2f);
        this.wrapped.renderer.setCircleTransparency(0.6f);
    }

    @Override
    public void draw(OwoUIDrawContext context, int mouseX, int mouseY, float partialTicks, float delta) {
        context.enableScissor(x, y, x + width, y + height);
        context.push();
        //noinspection IntegerDivisionInFloatingPointContext
        context.translate(x + width / 2, y + height / 2, 0);
        wrapped.render(context, mouseX, mouseY, partialTicks);
        context.pop();
        context.disableScissor();
    }

    @Override
    public void mount(ParentComponent parent, int x, int y) {
        super.mount(parent, x, y);
        parent.childById(ButtonComponent.class, "load-button").onPress(this::loadSpellToGame);
    }

    public void loadSpellToGame(ButtonComponent button) {
        var client = MinecraftClient.getInstance();
        var bookScreen = client.currentScreen;

        client.setScreen(new ConfirmScreen(ok -> {
            if (ok) {
                ModNetworking.CHANNEL.clientHandle().send(new LoadExampleSpellPacket(spell));
                client.setScreen(null);
            } else {
                client.setScreen(bookScreen);
            }
        },
                Text.translatable("trickster.message.import_example"),
                Text.translatable("trickster.message.import_example.description")
        ));
    }

    @Override
    public boolean onMouseScroll(double mouseX, double mouseY, double amount) {
        return wrapped.mouseScrolled(mouseX - width / 2d, mouseY - height / 2d, 0, amount);
    }

    @Override
    public boolean onMouseDrag(double mouseX, double mouseY, double deltaX, double deltaY, int button) {
        return wrapped.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean onMouseDown(double mouseX, double mouseY, int button) {
        return wrapped.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean onMouseUp(double mouseX, double mouseY, int button) {
        return wrapped.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean canFocus(FocusSource source) {
        return source == FocusSource.MOUSE_CLICK;
    }

    @Override
    protected int determineHorizontalContentSize(Sizing sizing) {
        return 100;
    }

    @Override
    protected int determineVerticalContentSize(Sizing sizing) {
        return 100;
    }

    public static SpellPreviewComponent parse(Element element) {
        UIParsing.expectAttributes(element, "spell");

        var spellString = element.getAttributeNode("spell").getTextContent();
        SpellPart spell;
        try {
            spell = SpellPart.fromBase64(spellString);
        } catch (Exception e) {
            throw new UIModelParsingException("Not a valid spell: " + spellString);
        }

        return new SpellPreviewComponent(spell);
    }
}