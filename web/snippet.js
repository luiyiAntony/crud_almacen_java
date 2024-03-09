// GLOBAL VARIABLES
data = {}

// LOAD THE VALUES FROM CACHE
data = JSON.parse(localStorage.getItem("dataMarket"));
data = data == null ? {} : data;
if (typeof(data) == "string") {
    console.log("removing data because is corrupted");
    data = {};
    localStorage.removeItem("dataMarket");
}

// SET THE VALUES 
document.addEventListener("DOMContentLoaded", () => {
    console.log(data);
    console.log(typeof(data));
    document.getElementById("category").value = data["category"] == null ? "all" : data["category"];
    document.getElementById("range").value = data["range"] == null ? "all" : data["range"];
    document.getElementById("price").value = data["price"] == null ? 100 : data["price"];
});

// HANDLERS
function onChangeCategory(event) {
    category_id = event.target.value;
    data["category"] = category_id;
}

function onChangeRange(event) {
    range = event.target.value;
    data["range"] = range;
    data["price"] = document.getElementById("price").value;
}

function onChangePrice(event) {
    price = event.target.value;
    data["price"] = price;
}

function filterLauncher() {
    localStorage.setItem("dataMarket", JSON.stringify(data));
    let URL = "";
    category = data["category"] == null ? "all" : data["category"];
    range = data["range"] == null ? "all" : data["range"];
    if (category == "all" && range == "all") {
        URL = `ProductosController`;
    } else {
        URL = `ProductosController?accion=filter`;
        if (data["category"] != "all") {
            URL += `&Category_id=${data["category"]}`;
        }
        if (data["range"] != "all") {
            URL += `&Range=${data["range"]}&Price=${data["price"]}`;
        }
    }
    console.log(data);
    console.log(URL);
    location.href = URL;
}