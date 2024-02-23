## Kojo Installation FAQ

### Font size adjustment

Kojo tries to scale up the size of its fonts and user interface based on your display resolution. If you want to adjust this size further, here's what you can do:  
Go to *File -> Settings*, and adjust the font size from there. Then restart Kojo.

---

### Dark Theme
Go to *File -> Settings*, and adjust the theme from there. Then restart Kojo.

---

### Silent Installs

You can do silent installs by running the Kojo installer with the `-q` option.

For example, on Windows, you can run the following (assuming that the file you have downloaded is `Kojo_windows-x64_2_9_23_with_jre.exe`):
```
Kojo_windows-x64_2_9_23_with_jre.exe -q
```

In a similar way, a silent uninstall can be done by running the uninstaller (from the Kojo install directory) with the `-q` option:
```
"C:\Program Files\Kojo\uninstall.exe" -q
```

---

### Installation on a Windows terminal server

Brief notes for now. If you want to do this, get in touch at `kojoinstall@kogics.net`.

*On the Server*
- Install Kojo on the server PC.
- Go into the kojo bin directory where kojo.exe is located
- Copy kojo-wts.cmd (shown below) into this directory

*On each of the client terminals*
- Go to *My computer* -> *Organize* -> *Folder and search options* -> *View* -> *Show hidden files*, and uncheck *Hide protected OS Files*.
- From each client access the the location where kojo-wts.cmd is saved.
- Create a shortcut for kojo-wts.cmd on your desktop (right click -send to desktop -create shortcut)
- Run this shortcut on the client terminals just as you would double click any other application. This will launch an independent copy of Kojo on the client.

Put the following into kojo-wts.cmd:  
``` bash
@echo off
set JAVA_HOME="..\jre"
SET kojolibdir="..\lib"
SET kojojavacp=
SETLOCAL EnableDelayedExpansion
FOR %%A IN (%kojolibdir%\*) DO ( 
  SET kojojavacp=!kojojavacp!;%%~A
)
echo %USERPROFILE%
call %JAVA_HOME%\bin\java -cp "%kojojavacp%" -client -Xms128m -Xmx2g -Xss1m --add-opens java.desktop/javax.swing.text.html=ALL-UNNAMED --add-opens java.desktop/sun.awt=ALL-UNNAMED --add-opens java.desktop/sun.swing=ALL-UNNAMED --add-opens java.desktop/sun.swing.table=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED -Dsun.java2d.uiScale.enabled=false net.kogics.kojo.lite.Main
```

  

