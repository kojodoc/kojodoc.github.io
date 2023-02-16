## Kojo Installation FAQ

### Font size adjustment

Kojo tries to scale up the size of its fonts and user interface based on your display resolution. If you want to adjust this size further, here's what you can do:  
Go to *File -> Settings*, and adjust the font size from there. Then restart Kojo.

### Dark Theme
Go to *File -> Settings*, and adjust the theme from there. Then restart Kojo.

### Silent Installs

You can do silent installs by running the Kojo installer with the `-q` option.

For example, on Windows, you can run the following (assuming that the file you have downloaded is `Kojo_windows-x64_2_9_23_with_jre.exe`):
```shell
Kojo_windows-x64_2_9_23_with_jre.exe -q
```

In a similar way, a silent uninstall can be done with something like:
```shell
"C:\Program Files\Kojo\uninstall.exe" -q
```