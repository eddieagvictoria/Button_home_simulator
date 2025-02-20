var exec = require('cordova/exec');

var AndroidButtonHome = {
    simulateHomeButton: function(successCallback, errorCallback) {
        exec(
            function(result) {
                // result es un objeto que contiene { success: boolean, message: string }
                if (result.success) {
                    successCallback(result.message); // Éxito
                } else {
                    errorCallback(result.message); // Error
                }
            },
            function(error) {
                errorCallback(error); // Error en la ejecución
            },
            "AndroidButtonHome",
            "simulateHomeButton",
            []
        );
    }
};

module.exports = AndroidButtonHome;