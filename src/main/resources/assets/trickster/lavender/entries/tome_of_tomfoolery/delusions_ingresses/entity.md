```json
{
  "title": "Entity Querying",
  "icon": "minecraft:cow_spawn_egg",
  "category": "trickster:delusions_ingresses"
}
```

Various tricks related to gathering data about entities.

;;;;;

<|glyph@trickster:templates|trick-id=trickster:get_entity_type,title=Motive Verification Ingress|>

entity -> entity_type

---

Given an entity, returns its type.

;;;;;

<|glyph@trickster:templates|trick-id=trickster:get_position,title=Locational Ingress|>

entity -> vector

---

Given an entity, returns its position in the world.

;;;;;

<|glyph@trickster:templates|trick-id=trickster:get_eye_position,title=Perspective Ingress|>

entity -> vector

---

Given an entity, returns the position of its head.

;;;;;

<|glyph@trickster:templates|trick-id=trickster:get_facing,title=Directional Ingress|>

entity -> vector

---

Given an entity, returns its facing as a vector.

;;;;;

<|glyph@trickster:templates|trick-id=trickster:get_velocity,title=Movement Ingress|>

entity -> vector

---

Given an entity, returns its current velocity as a vector.

;;;;;

<|glyph@trickster:templates|trick-id=trickster:height_reflection,title=Stature Ingress|>

entity -> number

---

Given an entity, returns its height in blocks.

;;;;;

<|glyph@trickster:templates|trick-id=trickster:sneaking_reflection,title=Alternative Ingress|>

entity -> boolean

---

Given an entity, returns whether the entity is crouching.

;;;;;

<|glyph@trickster:templates|trick-id=trickster:sprinting_reflection,title=Trekking Ingress|>

entity -> boolean

---

Given an entity, returns whether the entity is sprinting.

;;;;;

<|glyph@trickster:templates|trick-id=trickster:blocking_reflection,title=Guard Ingress|>

entity -> boolean

---

Given an entity, returns whether the entity is blocking using a shield.

;;;;;

<|glyph@trickster:templates|trick-id=trickster:get_max_health,title=Vigor Ingress|>

entity -> number

---

Given an entity, returns its maximum health.

;;;;;

<|glyph@trickster:templates|trick-id=trickster:get_health,title=Fettle Ingress|>

entity -> number

---

Given an entity, returns its current health.

;;;;;

<|glyph@trickster:templates|trick-id=trickster:get_mana,title=Ingress of Authority|>

entity | vector -> number

---

Given an entity or mana holding block position, returns its current mana.

;;;;;

<|glyph@trickster:templates|trick-id=trickster:get_armour,title=Bulwark Ingress|>

entity -> number

---

Given an entity, returns its total armor value.

;;;;;

<|glyph@trickster:templates|trick-id=trickster:get_scale,title=Distortion of Ingress|>

entity -> number

---

Returns the scale of the given entity.