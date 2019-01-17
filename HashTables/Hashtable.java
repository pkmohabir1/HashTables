import java.util.ArrayList;


public class Hashtable{

  public class HashNode{
    public String key;
    public String value;
    public HashNode next;
    public HashNode(String k, String v){
       key = k;
       value = v;
       next = null;
    } //HashNode Constructor
  } //HashNode Class
    private int num_buckets;
    private ArrayList<HashNode> buckets;
    private int size;

    public Hashtable(){
      num_buckets = 3000;
      size = 0;
      buckets = new ArrayList<HashNode>(num_buckets);
      for(int i = 0; i<num_buckets; i++){
        //HashNode node = null;
        buckets.add(null);
      }//for
    }//HashTable Constructor


    public int getBucket(String k){
      int hash_code = k.hashCode();
      return Math.abs(hash_code % num_buckets);
    }//getBucket

//_________________________________________________________________
    public boolean containsKey(String k){
      int bucket_id = getBucket(k);
      //find key
      HashNode node = buckets.get(bucket_id);
    //  node.value = buckets.get(bucket_id);
      while(node != null){
        if(node.key.equals(k)){
          return true;
        }//if
        node = node.next;
      }//while
      return false;
    }//containsKey
//_________________________________________________________________
    public void put(String k, String v){
      int bucket_id = getBucket(k);
      HashNode node = buckets.get(bucket_id);


     ++size;
	   HashNode node2 = new HashNode(k, v);
     node2.next = buckets.get(bucket_id);

     buckets.set(bucket_id, node2);

   }//put()
//_________________________________________________________________
  public String remove(String key){
		int bucket_id = getBucket(key);
		HashNode node = buckets.get(bucket_id);
		HashNode prev = null;
		while(node!= null){
			if(node.key.equals(key)){
				break;
			}//if
			prev = node;
			node = node.next;
		}//while

		if(node == null){
			return null;
		}//if
		--size;
		if(prev == null){
			buckets.set(bucket_id, node.next);
		}//if
		else{
			prev.next = node.next;
		}//else
		return node.value;
  }//remove()

// //_________________________________________________________________
  public String get(String k){

    int bucket_id = getBucket(k);
    HashNode node = buckets.get(bucket_id);
    while(node!=null){
      if(node.key.equals(k)){
        return node.value;
      }
      node = node.next;//if
    }//while
    return null;
  }//get()
}//Hashtable
