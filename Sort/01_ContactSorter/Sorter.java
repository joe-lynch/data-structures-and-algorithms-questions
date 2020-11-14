public class Sorter {
    
    public static void selectionSort(Contact[] contacts) {
        for (int i = 0; i < contacts.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < contacts.length; j++) {
                if (contacts[j].compareTo(contacts[minIndex]) < 0) {
                    minIndex = j;
                }
            }
        Contact temp=contacts[i]; 
        contacts[i]=contacts[minIndex]; 
        contacts[minIndex]=temp; 
        }
    }

    public static void insertionSort(Contact[] contacts) {
        for(int s = 2; s <= contacts.length; s++) {
            Contact sortMe = contacts[ s - 1 ];
            int i = s - 2;
            while (i >= 0 && sortMe.compareTo(contacts[i])<0) {
                contacts[i+1] = contacts[i];
                i--;
            }
            contacts[i+1] = sortMe;
        }
    }

    public static void quickSort(Contact[] contacts) {
        performQuickSort(contacts, 0, contacts.length-1);
    }
    
    public static Contact[] performQuickSort(Contact[] contacts, int first , int last){
        if (last-first >= 1){
            int pivotIndex;
            
            pivotIndex = partition(contacts,first,last);
            performQuickSort(contacts, first, pivotIndex-1); // left
            performQuickSort(contacts, pivotIndex+1, last); // right
        }
        return contacts;
    }
    
    
    public static int partition(Contact contacts[], int low, int high){
        int pi = low;
        Contact pivot = contacts[low];
        
        do{
            while ( low <= high && contacts[low].compareTo(pivot) <= 0 ){
                low++;
            }
            while ( contacts[high].compareTo(pivot) > 0 ){
                high--;
            }
            if ( low < high ){
                Contact temp=contacts[low]; 
                contacts[low]=contacts[high]; 
                contacts[high]=temp; 
            }
        }
        while ( low < high );
        Contact temp=contacts[pi]; 
        contacts[pi]=contacts[high]; 
        contacts[high]=temp; 
        pi = high;
        return(pi);
    }
    
}
