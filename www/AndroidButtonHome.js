var exec = require('cordova/exec');

var AndroidButtonHome = {
    simulateHomeButton: function(successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AndroidButtonHome", "simulateHomeButton", []);
    }
};

module.exports = AndroidButtonHome;