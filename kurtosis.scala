class TestClass {
    def kurt(eList: List[Employee]) : Double = 
  {
      var sum=0;
      eList.foreach(e => {
        sum+=e.salary
      })
      var mean=sum/eList.length
      //println("Mean: "+mean)
      var new_sum, new_sum_kurt, diff = 0.0000
      var f,g = 0.00f
      eList.foreach(e => {
        diff=e.salary-mean
        
        new_sum += Math.pow(diff, 2)
      })
      var variance=new_sum/(eList.length-1)
      //println("Variance "+variance)//
      
	  var std_dev=Math.sqrt(variance)
      //println("Standard Deviation "+std_dev)//
	  
      var n=eList.length
      f=(3*Math.pow((n-1),2)/((n-2)*(n-3))).toFloat
      g=(n*(n+1))/((n-1)*(n-2)*(n-3)).toFloat
      
      eList.foreach(e => {
        diff=e.salary-mean
        
        new_sum_kurt += Math.pow((diff/std_dev), 4)
      })
      
      var kurt=(g*new_sum_kurt)-(f)
      return kurt    
  }
}

object Main1{
  def main (args: Array[String]): Unit = {
    val t = new TestClass()

    var joe = new Employee("Joe", 10000)
    joe.dept = 10
    
    var jasmine = new Employee("Jasmine", 900000)
    jasmine.dept = 10
    
    var bharat = new Employee("Bharat", 1000000)
    bharat.dept = 10
    
    
    var chris = new Employee("Chris", 50000)
    chris.dept = 11
  
    var sara = new Employee ("Sara", 200000)
    sara.dept=12
    
    val eList = List(joe, chris, sara, jasmine, bharat)
    println("Kurtosis for Salary: " + t.kurt(eList))
    
    
  }
}