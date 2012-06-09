jpocket
=======

Java API for Pocket (formerly known as Read It Later)

Usage
=====
Saving New Web Pages
--------------------
```
SendProperties props = new SendProperties();
props.addURL("http://www.google.com");
// Chain methods
props.addURL("http://www.yahoo.com", "Yahoooooo").addURL("https://github.com/bostrt", "github");
// Set the page title
props.addURL("http://www.ubuntu.com", "Ubuntu");

JPocket.send(props);
```

Updating Page Titles
--------------------
```
SendProperties props = new SendProperties();
props.updateTitle("http://www.google.com", "Google");
props.updateTitle("http://www.yahoo.com", "Yahoo");

JPocket.send(props);
```

Updating Page Tags
--------------------
```
SendProperties props = new SendProperties();
props.updateTags("http://www.google.com", "search,email");
props.updateTitle("http://www.yahoo.com", "search,news,old");

JPocket.send(props);
```

Mark Pages as Read
--------------------
```
SendProperties props = new SendProperties();
// Combine properties
props.newURL("http://github.com");
props.markRead("http://www.google.com").markRead("https://github.com/bostrt");

JPocket.send(props);
```

Sign-up a New User
------------------
```
JPocket.signup("testUsername", "superSecretPassword1");
```