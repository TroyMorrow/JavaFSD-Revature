const employee = {
    firstname:'Mark',
    lastname:'Smith',
    getFullName : function(){
        
        console.log(this)
        return this.firstname + ' ' + this.lastname;
    
    }
}

employee.getFullName();
