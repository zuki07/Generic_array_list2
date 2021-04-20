



package generic_array_list2;

import java.util.ArrayList;


public class MyList <T extends Number>{
    
    private ArrayList<T> list=new ArrayList<>();
    
//                                    ADD METHOD
    public void add(T element){
        list.add(element);                                                          //add passed in generic element to array list
    }
    
//                                    LARGEST METHOD
    public <T extends Comparable<T>> T largest(){
        T largest_value=(T)list.get(0);                                             //set generic largest_value to first item of generic array list
        
        for (int i=1; i<list.size(); i++){                                          //step through generic array list starting at second position
            if (((T)list.get(i)).compareTo(largest_value)>0){                       //if generic array list index is > than largest_value
                largest_value=(T)list.get(i);                                       //set largest_value to index of generic array list
            }
        }                                                                           //else, do nothing and move to next index
        return largest_value;
    }
    
//                                    SMALLEST METHOD
    public <T extends Comparable<T>> T smallest(){
        T smallest_value=(T)list.get(0);                                            //set generic smallest_value to first item of generic array list
        
        for (int i=1; i<list.size(); i++){                                          //step through generic array list starting at second position
            if (((T)list.get(i)).compareTo(smallest_value)<0){                      //if generic array list index is < than smallest_value
                smallest_value=(T)list.get(i);                                      //set smallest_value to index of generic array list
            }
        }                                                                           //else, do nothing and move to next index
        return smallest_value;
    }
    
//                                    PRINT ARRAY LIST AS STRING METHOD
    public String printArrayList(){
        String str="";
        for (int index=0; index<list.size(); index++){                              //step through the generic array
            if (index==list.size()-1){                                              //if only 1 element or last element in generic array list, do the following
                str=str+list.get(index);                                            //set str to last element or only element of generic array list
            }
            else{                                                                   //all other elements in the generic array, do the following
                str=str+list.get(index)+", ";                                       //add first element in generic array to str and add comma with a space at the end
            }
        }
        return str;
    }
    
//                                    CLEAR ARRAY LIST METHOD
    public void clearArrayList(){
        list.clear();                                                               //clear generic array list
    }
    
}
