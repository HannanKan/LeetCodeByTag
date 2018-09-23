/*
problem: Merge k sorted linked lists and return it as one sorted list.
		Analyze and describe its complexity.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeLists(struct ListNode**lists,int left,int right);
struct ListNode* merge2list(struct ListNode* l1,struct ListNode*l2);

struct ListNode* mergeKLists(struct ListNode** lists, int listsSize) {
    if(listsSize==0) return NULL;	//special case need thinking
    return mergeLists(lists,0,listsSize-1);
    
}

//left and right indicate the indice
struct ListNode* mergeLists(struct ListNode**lists,int left,int right){
	//base case are probably two condition
    if(left==right-1){
        struct ListNode* tmp=merge2list(lists[left],lists[right]);
        return tmp;
    }
    if(left==right) return lists[left];
    
    int l_mid=(left+right)/2;
    int r_mid=l_mid+1;
    struct ListNode* l=mergeLists(lists, left,l_mid);
    struct ListNode* r=mergeLists(lists,r_mid,right);
    return merge2list(l,r);
}
struct ListNode* merge2list(struct ListNode* l1,struct ListNode*l2){
    if(l1==NULL) return l2;
    if(l2==NULL) return l1;
    struct ListNode* head=NULL,*p=NULL;
    while(l1!=NULL&&l2!=NULL){
        if(l1->val <= l2->val){
            if(head==NULL)  head=p=l1;
            else {
                p->next=l1;
                p=p->next;
            }
            l1=l1->next;
        }
        else{
            if(head==NULL)  head=p=l2;
            else 
            {
                p->next=l2;
                p=p->next;
            }
            l2=l2->next;
        }
    }
	//use if instead of while
    if(l1!=NULL)
        p->next=l1;
    if(l2!=NULL)
        p->next=l2;
    return head;
}