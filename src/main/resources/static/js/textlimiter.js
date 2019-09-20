function setTextLimit(inputContainerSelectorClass, lengthContainerSelectorClass) {
    var inputContainer = document.querySelector("."+inputContainerSelectorClass);
    var textLength = document.querySelector("."+lengthContainerSelectorClass);

    inputContainer.addEventListener("keyup", function () {
        functionCheckAboutLimit();
    })

    inputContainer.addEventListener("input", function () {
        functionCheckAboutLimit();
    })

    functionCheckAboutLimit = function () {
        inputContainer.value = inputContainer.value.substring(0, 500);

        var text = inputContainer.value;
        textLength.innerHTML = text.length;
        if (text.length < 300) {
            setContainerMode("error");
        } else if (text.length > 300 && text.length <= 500) {
            setContainerMode("success");
        } else {
            setContainerMode();
        }
    }

    setContainerMode = function (mode) {
        if (mode === "success") {
            textLength.classList.add("text-success")
            textLength.classList.remove("text-danger")
        } else if (mode === "error") {
            textLength.classList.remove("text-success")
            textLength.classList.add("text-danger")
        }
    }

}
