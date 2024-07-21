document.addEventListener('DOMContentLoaded', function() {
    console.log("JavaScript Loaded");
    // Additional JavaScript for interactive elements can be added here

    // Add event listener to the button
    document.getElementById("btn").addEventListener("click", function() {
        console.log("Button clicked");
        // Get the input value
        const input = document.getElementById("input").value;
        // Create a new list item
        const li = document.createElement("li");
        // Set the text of the list item
        li.appendChild(document.createTextNode(input));
        // Add the list item to the list
        document.getElementById("list").appendChild(li);

        // Clear the input
        document.getElementById("input").value = "";

    });

    // Add event listener to the list
    document.getElementById("list").addEventListener("click", function(event) {
        console.log("List item clicked");
        // Check if the clicked element is a list item
        if (event.target.tagName === "LI") {
            // Remove the list item
            event.target.remove();
        }
    });

});
