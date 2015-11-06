# PersonalProject
This project is a Android application that creates and solve math equations on flashcards

The application runs on android devices of sdk 15 or higher.  

Install instructions: 
	Open up source files in the android sdk and sync to a device through usb. Ensure the device is on developer mode at the bottom of settings. If a developer mode does not exist at the bottom of settings go to about phone, scroll down to the bottom and tap on the last item close to 7 times there should be something that notifies you that you are now a developer. When the device is connected to the computer there is going to be a popup menu on the phone asking you if you trust the computer. Select yes. After you have your device in developer mode and the source code files inside the sdk hit the green play button at the top. There should be a prompt that asked you if you want to use a device or the virtual phone. Select your device. Pick up the phone and go to the central apps button and the program should be installed. Run and test the app.

Known limitation: 
	A Deck can only hold 100 flashcards and the static variable deck is static because I could not implement writing to a file or database in the scope of this class and therefore when the program is closed and re-opened, the pre-existing flashcards are deleted.
