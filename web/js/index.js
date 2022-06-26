
var filterArray = [
    ["https://a0.muscache.com/pictures/8e507f16-4943-4be9-b707-59bd38d56309.jpg", "섬"],
    ["https://a0.muscache.com/pictures/c0a24c04-ce1f-490c-833f-987613930eca.jpg", "국립공원"],
    ["https://a0.muscache.com/pictures/732edad8-3ae0-49a8-a451-29a8010dcc0c.jpg", "통나무집"],
    ["https://a0.muscache.com/pictures/c5a4f6fc-c92c-4ae8-87dd-57f1ff1b89a6.jpg", "기상천외한 숙소"],
    ["https://a0.muscache.com/pictures/10ce1091-c854-40f3-a2fb-defc2995bcaf.jpg", "해변 근처"],
    ["https://a0.muscache.com/pictures/35919456-df89-4024-ad50-5fcb7a472df9.jpg", "초소형 주택"],
    ["https://a0.muscache.com/pictures/50861fca-582c-4bcc-89d3-857fb7ca6528.jpg", "디자인"],
    ["https://a0.muscache.com/pictures/ca25c7f3-0d1f-432b-9efa-b9f5dc6d8770.jpg", "캠핑장"],
    ["https://a0.muscache.com/pictures/1d477273-96d6-4819-9bda-9085f809dad3.jpg", "A자형 주택"],
    ["https://a0.muscache.com/pictures/677a041d-7264-4c45-bb72-52bff21eb6e8.jpg", "호숫가"],
    ["https://a0.muscache.com/pictures/8b44f770-7156-4c7b-b4d3-d92549c8652f.jpg", "북극"],
    ["https://a0.muscache.com/pictures/3fb523a0-b622-4368-8142-b5e03df7549b.jpg", "멋진 수영장"],
    ["https://a0.muscache.com/pictures/4221e293-4770-4ea8-a4fa-9972158d4004.jpg", "동굴"],
    ["https://a0.muscache.com/pictures/957f8022-dfd7-426c-99fd-77ed792f6d7a.jpg", "서핑"],
    ["https://a0.muscache.com/pictures/3b1eb541-46d9-4bef-abc4-c37d77e3c21b.jpg", "최고의 전망"],
    ["https://a0.muscache.com/pictures/d7445031-62c4-46d0-91c3-4f29f9790f7a.jpg", "복토 주택"],
    ["https://a0.muscache.com/pictures/ee9e2a40-ffac-4db9-9080-b351efc3cfc4.jpg", "열대 지역"],
    ["https://a0.muscache.com/pictures/5ed8f7c7-2e1f-43a8-9a39-4edfc81a3325.jpg", "B&B"],
    ["https://a0.muscache.com/pictures/c8e2ed05-c666-47b6-99fc-4cb6edcde6b4.jpg", "Luxe"],
    ["https://a0.muscache.com/pictures/52c8d856-33d0-445a-a040-a162374de100.jpg", "셰어하우스"],
    ["https://a0.muscache.com/pictures/1b6a8b70-a3b6-48b5-88e1-2243d9172c06.jpg", "농장"],
    ["https://a0.muscache.com/pictures/6ad4bd95-f086-437d-97e3-14d12155ddfe.jpg", "한적한 시골"]
]

var filterDiv = document.getElementById("filter_btns");
if (filterArray.length>11) var index=11;
else var index=filterArray.length;
for (var i=0; i<index; i++) {
    var div = document.createElement("button");
    div.className = "filter";
    var img = document.createElement("img");
    img.src = filterArray[i][0];
    var span = document.createElement("span");
    span.innerText = filterArray[i][1];
    div.appendChild(img);
    div.appendChild(span);
    filterDiv.appendChild(div);
}


var imgBoxs = document.getElementsByClassName("imgBox");
for(var ele of imgBoxs) {
    console.log(ele);
    ele.getElementsByClassName("left_roll")[0].addEventListener("click", ()=>{
        console.log(ele.getElementsByClassName("left_roll")[0]);
        for(var i=0; i<3; i++) {
            console.log(ele.getElementsByTagName("img")[i]);
            console.log(ele.getElementsByTagName("img")[i].style);
            if(ele.getElementsByTagName("img")[i].style.display == "block") {
                ele.getElementsByTagName("img")[i].style.display = "none";
                ele.getElementsByTagName("img")[(i+3)%3].style.display = "block";
                break;
            }
        }
    })
}

fetch("/accom/all", {method:"GET"})
.then((response) => {
    console.log("response:", response);
    return response.json();
})
.then((data)=>{
    console.log("data:", data);

    var item = document.getElementsByClassName("item")[0].cloneNode(true);
    console.log("item:", item);
})
.catch((error) => {
    console.log("error:", error);
});