# quizdroid4
Homework requirement:

An application that will allow users to take multiple-choice quizzes
now we will write the code to check the questions periodically, store the data, and allow for preferences


Stories:

As a user, the application should provide a "Preferences" action bar item that brings up a "Preferences" activity containing the application's configurable settings: URL to use for question data, and how often to check for new downloads, the "N" (minutes/hours) in the previous story. If a download is currently under way, these settings should not take effect until the next download starts.

As a developer, the application should create some background operation (Thread, AlarmManager or Service) that will (eventually) attempt to download a JSON file containing the questions from the server every "N" minutes/hours. For now, pop a Toast message displaying the URL that will eventually be hit. Make sure this URL is what's defined in the Preferences.
 
Homework Grading:

All your code should be in a GitHub repo under your account
repo should be called 'quizdroid'
repo should contain all necessary build artifacts
include a directory called "screenshots", including:
screenshot of app running on emulator
pic or screenshot or movie of app running on a device
