const dropArea = document.querySelector(".drop-area");
const dragText = dropArea.querySelector('h2');
const button = document.getElementById("select-button");
const input = dropArea.querySelector("#input-file");
const form = document.getElementById("submitForm");
let files;


button.addEventListener("click", () => {
    input.click();
});

input.addEventListener("change", (e) => {
    files = input.files;
    dropArea.classList.add("active");
    showFiles(files);
    dropArea.classList.remove("active");
});

dropArea.addEventListener("dragover", (e) => {
    e.preventDefault();
    dropArea.classList.add("active");
    dragText.textContent = "Suelta para subir los archivos";
});

dropArea.addEventListener("dragleave", (e) => {
    e.preventDefault();
    dropArea.classList.remove("active");
    dragText.textContent = "Arrastra y suelta imágenes";
});

dropArea.addEventListener("drop", (e) => {
    e.preventDefault();
    files = e.dataTransfer.files;
    showFiles(files);
    dropArea.classList.remove("active");
    dragText.textContent = "Drag and Drop a Profile Picture";
});

function showFiles(files) {
    if (files.length === undefined) {
        processFile(files);
    } else {
        processFile(files[0]);
    }
}

function processFile(file) {
    const docType = file.type;
    const validExtensions = ["image/jpeg", "image/jpg", "image/png", "image/gif"];

    if (validExtensions.includes(docType)) {
        const fileReader = new FileReader();
        const id = `file-${Math.random().toString(32).substring(7)}`;

        fileReader.addEventListener('load', e => {
            const fileUrl = fileReader.result;
            const image = `
                        <div id="${id}" class="file-container">
                            <img src="${fileUrl}" alt="${file.name}" width="50px">
                            <div class="status">
                                <span>${file.name}</span>
                            </div>
                        </div>
                    `;
            document.querySelector('#preview').innerHTML = image;
        });

        fileReader.readAsDataURL(file);
    } else {
        alert("No es un archivo válido");
    }
}

form.addEventListener("submit", (e) => {
    if (files && files.length > 0) {
        // Asignar el archivo seleccionado al input original para enviarlo con el formulario
        input.files = files;
    }
});



