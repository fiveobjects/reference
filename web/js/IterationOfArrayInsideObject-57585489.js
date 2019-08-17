var data = {
    "groupname": [{ "id": 12, "group_name": "sd" }, { "id": 11, "group_name": "ghf" }, { "id": 10, "group_name": "sdf" }, { "id": 9, "group_name": "dsf" }, { "id": 5, "group_name": "g" }, { "id": 4, "group_name": "too" }, { "id": 3, "group_name": "lol" }, { "id": 2, "group_name": "hh" }, { "id": 1, "group_name": "TestGroup" }],
    "question_count": [{ "count": 1 }, { "count": 3 }, { "count": 1 }, { "count": 6 }, { "count": 1 }, { "count": 5 }], "img_url": "http:\/\/localhost\/O2X\/Trunk\/Web\/public\/admin\/images\/icn_close.png", "drag_img_url": "http:\/\/localhost\/O2X\/Trunk\/Web\/public\/admin\/images\/drag-handle.png"
};
// data.groupname.forEach(token => {
//     txt = '<tr class="row1" data-id="' + token.id + '"><td>' + token.group_name + '</td>';
//     console.log(txt);
// });
console.log(Object.keys(data).length)
for (var i = 0; i < data.groupname.length; i++) {
    if (data.groupname[i].group_name) {
        txt = '<tr class="row1" data-id="' + data.groupname[i].id + '"><td>' + data.groupname[i].group_name + '</td>';
    }
    console.log(txt);
}