[![](https://jitpack.io/v/top.offsetmonkey538/When-Entities-Die.svg)](https://jitpack.io/#top.offsetmonkey538/When-Entities-Die)
# Description
## Installation
Just download the latest version from the [versions page](https://modrinth.com/mod/when-entities-die/versions) and put it in the `mods` folder. Fabric API is not needed to use this mod. **The mod only needs to be installed on the server**
## Usage
### Datapacks
Inside a datapack, you make a normal advancement and use the `when-entities-die:killed_using_item` trigger.

Example advancement that triggers when a player kills a skeleton using a diamond sword:
```json
{
  "display": {
    "icon": {
      "item": "minecraft:apple"
    },
    "title": {
      "text": "Test advancement"
    },
    "description": {
      "text": "Test advancement description"
    },
    "frame": "task",
    "show_toast": true,
    "announce_to_chat": true,
    "hidden": false
  },
  "criteria": {
    "requirement": {
      "trigger": "when-entities-die:killed_using_item",
      "conditions": {
        "item": {
            "items": [
              "minecraft:diamond_sword"
            ]
        },
        "entity": {
          "type": "minecraft:skeleton"
        }
      }
    }
  }
}
```
### Mods
Inside a mod, you do exactly the same thing as in a datapack.

You can also include this mod in your mod.
#### Example repositories block in build.gradle
```groovy
repositories {
    maven {
        name = "JitPack"
        url = "https://jitpack.io/"
        content {
            includeGroup "top.offsetmonkey538"
        }
    }
}
```
#### Example dependencies block in build.gradle
```groovy
dependencies {
    modImplementation include("top.offsetmonkey538:when-entities-die:v1.0+1.19")
}
```
*Note: this example will get updated to use the latest version. You can look at all the versions on [jitpack](https://jitpack.io/#top.offsetmonkey538/When-Entities-Die).*