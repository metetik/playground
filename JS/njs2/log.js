var log = {
    information : function(info) {
        console.log("İnfo : " + info)
    },
    fault : function (fault) {
        console.log("Fault : " + fault)
    }
}

module.exports = log

//ES6 => """export default log"""