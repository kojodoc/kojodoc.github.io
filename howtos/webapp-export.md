<div class="nav">
  <a href="../index.html">Home</a> | <a href="../turtle-index.html">Turtle Graphics</a> | <a href="../references-index.html">References</a>
</div>

## Web-App export and deployment

Steps in brief (for now; more details soon):

### Exporting the Web-App
* Load the script you want to export in the script editor in desktop-Kojo.
* Clock on *File -> Export Script as Web-App*.
* This will compile the script via iKojo, and create a Web-App based on the script under `~/kojo-export`.

### Running the Web-App locally
* Go over to `~/kojo-export`, and launch index.html. This will open your system browser and start running the exported Web-App.

### Putting the Web-App in the cloud (using Netlify)
* Assume that your Web-App will go live at `https://yourapp.netlify.app`
* Under the `~/kojo-export/webapp` folder, update icon.png (if you want)
* Under the `~/kojo-export/webapp` folder, update manifest.json (set `start_url` and `url` to `https://yourapp.netlify.app`)
* Login to netlify (you can use your github id for this).
* Drag-n-drop your webapp folder onto the netlify page to create a new site (with a netlify generated name).
* Go to site settings and change the site name to `yourapp` from the netlify generated name.
* Your site will now be live at `https://yourapp.netlify.app`

### Creating a mobile app from your Web-App
* Point PWABuilder (www.pwabuilder.com) at your Web-App to generate an android app.
* More information on this soon...
