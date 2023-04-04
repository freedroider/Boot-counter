
## TODOs & Edge scenarios

 - [ ] Currently, the app works only with `android.intent.action.BOOT_COMPLETED` events. Need to ask PO if we need to handle: 
	  - `android.intent.action.QUICKBOOT_POWERON` is received after a "restart" or a "reboot"
	  - `android.intent.action.LOCKED_BOOT_COMPLETED` is broadcast once, after the user has finished booting, but while still in the "locked" state.
	  - some manufacturers can implement their mechanisms/actions to notify apps about reboot events. Do we need to investigate, test and check how XYZ devices work with it?
	  - the app doesn't handle some cases when a user changes the date/time. Should we cover it?
 - [ ] The app doesn't show notifications. So, need to add:
	  - Check notifications permissions for Android 13 and higher
	  - Create notification channel
	  - Create and show notification
	  - Add Worker manager to make periodical work (run every 15 minutes Worker to show notifications)
 - [ ]  Move libraries versions to the toml file (libs.versions.toml)
 - [ ] We can move saving from a broadcast receiver to a service. 
 - [ ]  Add 4 app modules and move classes and dependencies from packages to modules: 
	  - `common`
	  - `data`
	  - `domain`
	  - `presentation`
To separate interfaces and implementations, avoid issues with dependencies, etc.
 - [ ]  Add `UseCase` classes on `domain`-layer
 - [ ] Need to cover codebase by Unit-tests and if we have enough time integration tests.
