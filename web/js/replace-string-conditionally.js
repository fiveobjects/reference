idk = "Monday, 2nd - October, 23:59";
whitelistmes = ["January", "October"];
whitelistdias = ["Tuesday", "Monday"];
if (idk.includes("/") || idk.includes("-")) {
    [...whitelistmes].forEach(token => {
        if (idk.includes(token)) {
            idk = idk.replace(token, "");
        }
    });

    [...whitelistdias].forEach(token => {
        if (idk.includes(token)) {
            idk = idk.replace(token, "");
        }
    });
}
console.log(idk);