package io.ipfs.upload;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;

//@Data
//@AllArgsConstructor
//@Builder
public class CID {
    private String cid;
    public String get(){
        return cid;
    }
    public void set(String cid) {
        this.cid = cid;
    }


}
