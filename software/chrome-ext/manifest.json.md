# manifest.json

- browser_action means that this extension is going to be a button that is gonna
  be available at the toolbar

```json
{
    "manifest_version": 2,
    "name": "hwext",
    "description": "hw extension",
    "version": "0.0.1",

    // toolbar icon
    "browser_action": {
        "default_icon": "icon.png",
        "default_popup": "popup.html" // shown when clicked on toolbar button
    }
}
```
