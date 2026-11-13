# JakartaDeRoll

```mermaid
classDiagram
    class Campaign{
    }
    class Session{
    }
    class Event{
    }
    class Players{
    }
    class Characters{
    }
    class CharacterSheet{
    }
    Characters "1" *-- "1" CharacterSheet
    Campaign "1" *-- "0..n" Session
    Event "1" *-- "0..n" Event
    Campaign "1" *-- "0..n" Event
    Session "0..n" -- "0..n" Event
    Campaign "0..n" -- "1..n" Players
    Players "1" o-- "0..n" Characters
    Campaign "1" *-- "0..n" Characters
```