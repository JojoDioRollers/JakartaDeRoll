# JakartaDeRoll

```mermaid
classDiagram
    note for Campaign "only gamemaster can modify things related to this Campaign, even if it is not the Campaign."
    class Campaign{
        -name : String
        -gamemaster : Player
        -description : Text
        +Campaign(Player : gamemaster, name : String)
        +addPlayer(Player : player)
        +getPlayers() List of Players // should exclude gamemaster
        +toString() String // should dislplay name then gm & players and lastly the description
    }
    class Session{
        -date : date
        -description : String
        +addPlayer(Player : player)
        +Session(List of Players : players) // gm not in list because automatically present
    }
    note for Event "probably abstract if we find the time to generate descriptions"
    class Event{
        -name : String
        -description : Text
        +Event(String : name, Campaign : campaign)
        +addSession(Session : session)
        +addChars(List of Characters : characters)
        +addEvent(String : name) // calls Event(name,this.campaign)
        +getInvolved() List of characters
        +toString() String // name then Characters involved, PC and NPC separated then description 
    }
    class Player{
        -name : String // alias e.g. sorcero
    }
    class Character{
        -name : String
        -description : Text
        -notes : Text
        +roll(Roll : type)
    }
    Agility, Constitution, Empathy, Intuition, Memory, Presence, Quickness, Reasoning, Self-Discipline, Strength
    note for CharacterSheet "for base_stats and stats, an enum is needed to handle the index. Same for base_res and res.<br>the 10 stats are, in order : Agility, Constitution, Empathy, Intuition, Memory, Presence, Quickness, Reasoning, Self-Discipline and Strength<br>the  resistances are, in order: Physical, Fear, Channeling, Essence and Mentalism"
    class CharacterSheet{
        -level : int
        -base_stats : Stat[10]
        -base_res : int[5]
        -base_hits : int
        -hits_current : int
        -endurance : int
        -recovery : double
        -Size : int
        -stride : int
        -height : int // sadly, in inches
        -weight : int // in pounds. sorry
        -training : Map&lt;Skill.name&gt; int
        // Derived values, not stored in database
        -hits_max : int
        -stats : int[10]
        -res : int[5]
        -skills : Map&lt;Skill.name&gt; int
    }
    class Stat{
        -potential : int
        -current : int
    }
    class Skill{
        -name : String //serves as id
        -stats : int[3]
    }
    Character "1\n-sheet" *-- "1" CharacterSheet
    Campaign "1" *-- "-campaign\n0..*" Session
    Event "-events\n1" *-- "0..*" Event
    Campaign "1" *-- "-campaign\n0..*" Event
    Session "0..*" -- "0..*" Event
    Campaign "0..*" -- "1..*" Player
    Player "1" o-- "-player\n0..*" Character
    Campaign "1" *-- "-campaign\n0..*" Character
    Event "0..*" -- "0..*" Character
    Session "0..*" -- "1..*" Player
    CharacterSheet --> Skill
    CharacterSheet --> Stat

    class Roll{
        <<Interface>>
        +roll() int
    }
    class Roll_OE{
        +roll() int //1d100, open ended
    }
    class Roll_Sup{
        +roll() int //1d100, open ended to +inf 
    }
    class Roll_100{
        +roll() int //1d100
    }
    class Roll_10{
        +roll() int //1d10
    }
    class Roll_Dice{
        -int : faces
        +roll() int //1d&lt;x&gt;, &lt;x&gt; = faces
    }
    class Roll_Skill{
        -bonus : int // calc with args in the creator
        +roll() int // OE + bonus
        +Roll_Skill(Character : character, Skill : skill) int // to calc bonus
    }
    class Roll_RR{
        -bonus : int
        +roll() int // OE + bonus
        +Roll_RR(Character : character, int : res_type)
    }
    class Roll_Endu{
        -bonus : int
        +roll() int // Roll_Skill for body development + bonus (endurance)
        +Roll_Endu(Character : character) int
    }
    class Roll_Init{
        -bonus : int
        +roll() // 2d10 + bonus:
        +Roll_Init(Character : character) int
    }
    Character --> Roll
    Roll <|.. Roll_OE
    Roll <|.. Roll_Sup
    Roll <|.. Roll_100
    Roll <|.. Roll_10
    Roll <|.. Roll_Dice
    Roll <|.. Roll_Skill
    Roll <|.. Roll_RR
    Roll <|.. Roll_Endu
    Roll <|.. Roll_Init
    Roll_Endu --> Roll_Skill
    Roll_Skill --> Roll_OE
    Roll_RR --> Roll_OE
    Roll_OE --> Roll_Sup
    Roll_Sup --> Roll_100
    Roll_Init --> Roll_10
    Roll_Skill --> Skill
    Roll_Skill --> Character
    Roll_Init --> Character
    Roll_Endu --> Character
    Roll_RR --> Character
    note for Roll "roll function will work differently depending on what kind of Roll it is"
```