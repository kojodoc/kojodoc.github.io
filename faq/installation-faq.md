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

- Use the cross-platform Kojo installer
- After installation, in the Kojo bin directory, make a copy of kojo.cmd called, say, kojo-wt.cmd
- Put the following into kojo-wt.cmd:  
```
@echo off
SET kojolibdir="..\lib"
SET kojojavacp=
SETLOCAL EnableDelayedExpansion
echo %kojolibdir%
FOR %%A IN (%kojolibdir%\*) DO ( 
  SET kojojavacp=!kojojavacp!;%%~A
)
echo %kojojavacp%
call java -cp "%kojojavacp%" -Duser.home=instanceSpecificDir net.kogics.kojo.lite.NewKojoInstance
```
Where instanceSpecificDir is different for each Kojo instance.
- Run Kojo using kojo-wt.cmd
  

