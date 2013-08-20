Remote Code Execution
==============

This Project is created for my Youtube Series to teach some Android Concepts.
Its playlist is located here -> http://www.youtube.com/playlist?list=PLPqamfJl5eh-rx3nFiPR5XIRxd1ynioFH

With this app, you can specify commands and send them per SMS.
The app catches them, looks if the SMS content matches the commands, removes the SMS from the inbox (or better said, it doesnt let the inbox know that we just received a SMS) and executes the command.

Commands by now
===============
COMMANDS MARKED WITH * REQUIRE ROOT

1. Test
	* Starts MainActivity
2. listSdCard
	* Lists the sdcard and saves it to the SDCARD as textfile
3. REBOOT
	* Reboots the Phone
4. Vanish
	* Disables MainActivity and removes it from the App Launcher
	(in combination with a dummy launcher activity it can be used for malicious apps, caution)
5. installSystem
	* Installs the APP as System App and reboots the phone
6. removepattern
	* Removes all Screen Protections like Patters, PIN and Passwords

EOF
================
