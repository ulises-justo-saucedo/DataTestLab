## DataTestLab
DataTestLab is an Android project designed for testing Firebase functionality. It leverages Firebase Authentication and Firebase Cloud Firestore for user authentication, registration, and data storage.

## Firebase Authentication
Through the Firebase Console, I’ve enabled Email/Password authentication. This feature allows the Android application to support basic Email/Password login and registration without requiring a Google Account, SMS Authentication, or any other login method.

## Firebase Cloud Firestore
DataTestLab utilizes Cloud Firestore to store data. Each document in the Firestore collection represents an animal and contains three properties: Name, Type, and Age. Users can save animal data by filling out these properties within the application. When they choose to save an animal, the information they provide is directly stored in the Cloud Firestore associated with the application.
