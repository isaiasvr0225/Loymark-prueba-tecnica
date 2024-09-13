function validateForm() {
    var name = document.getElementById("name").value;
    var price = document.getElementById("price").value;
    var description = document.getElementById("description").value;

    if (name === "") {
        alert("Please enter a product name.");
        return false;
    }

    if (price <= 0) {
        alert("Price must be a positive number.");
        return false;
    }

    if (description === "") {
        alert("Please enter a product description.");
        return false;
    }

    return true;
}

document.getElementById("addProductForm").addEventListener("submit", function(event) {
    if (!validateForm()) {
        event.preventDefault();
    }
});