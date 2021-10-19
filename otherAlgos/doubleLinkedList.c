#include<stdio.h>
#include<stdlib.h>

struct node{
    int id;
    int data;
    struct node* next;
    struct node* prev;
};

// void binarySearch(struct node* start,struct node* end,int seek)
// {
//     struct node* trav=start;
//                 int middle=((start->id)+(end->id))/2;
//                 while(trav->id!=middle)
//                 {
//                     trav=trav->next;
//                 }
//                 if(trav->data==seek)
//                 {
//                     printf("The requested data found at ID=%d",trav->id);
//                 }
//                 else if(trav->data<seek)
//                 {
//                     start=head;
//                     end=trav->prev;
//                     binarySearch();
//                 }
//                 else
//                 {
//                     start=trav->next;
//                     end=last;
//                     binarySearch();
//                 }
            
// }



int main()
{
    int i=1;
    struct node *head=NULL,*last=NULL,*t=NULL;
    for(;;)
    {
        int r;
        printf("press:\n 1 To Enter data \n 2 To delete a node \n 3 To insert a node\n 4 To print the linked list.\n 5 To sort the linked list\n 6 To search an element\n 7 To Terminate the program\n");
        scanf("%d",&r);
        //Creating a Node
        if(r==1)
        {
            t=(struct node*)malloc(sizeof(struct node));
            scanf("%d",&t->data);
            t->id=i;
            i++;
            t->next=NULL;
            if(head==NULL)
            {

                head=t;
                last=t;
                head->prev=NULL;
            }
            else
            {
                last->next=t;
                last->next->prev=last;
                last=t;
            }

        }
        //Creating a node ends here
        //Deleting a node
        else if(r==2)
        {
            struct node* temp=NULL;
            t=(struct node*)malloc(sizeof(struct node));
            int del;
            printf("Enter the id of the node you want to delete.\n");
            scanf("%d",&del);

            if(del==head->id)
            {
                head->next->prev=NULL;
                free(head);
            }
            else if(del==last->id)
            {
                last->prev->next=NULL;
                free(last);
            }
            else
            {
                if(del<head->id || del>last->id)
                {
                    printf("Invalid ID\n");
                }
                else
                {
                     t=head;
                    while(t->id!=del)
                    {
                        t=t->next;
                    }
                    temp=t->next;
                    while(temp!=NULL)
                    {
                        temp->id=(temp->id)-1;
                        temp=temp->next;
                    }
                    t->prev->next=t->next;
                    t->next->prev=t->prev;
                    free(t);
                }

            }
        }
        //Deleting a node ends here
        //Inserting a node at any index
        else if(r==3)
        {
            int ins;
            struct node* temp;
            t=(struct node*)malloc(sizeof(struct node));
            printf("Enter the id on which you want to insert the node:\n");
            scanf("%d",&ins);
            t->id=ins;
            printf("Enter the data for the newly inserted node.\n");
            scanf("%d",&t->data);
            temp=head;
            while(temp->id!=ins)
            {
                temp=temp->next;
            }
            temp->prev->next=t;
            t->next=temp;
            t->prev=temp->prev;
            temp->prev=t;
            while(temp!=NULL)
            {
                temp->id=(temp->id)+1;
                temp=temp->next;
            }
        }
        //Inserting a node at any index ends here
        //Printing The Linked List
        else if(r==4)
        {
            /*t=head;

            while(t!=NULL)
            {
                printf("id=%d data=%d\n",t->id,t->data);
                t=t->next;
            }
            */
            t=last;
            while(t!=NULL)
            {
                printf("id=%d data=%d\n",t->id,t->data);
                t=t->prev;
            }


        }
        //Printing the Linked List ends here
        //Selection sorting starts here
        else if(r==5)
        {
            struct node* temp;
            temp=head;
            while(temp!=NULL)
            {
                struct node* trav=temp->next;
                while(trav!=NULL)
                {
                    if((trav->data) < (temp->data))
                    {
                        int darshan=(trav->data);
                        trav->data=(temp->data);
                        temp->data=darshan;
                    }
                    trav=trav->next;
                }
                temp=temp->next;
            }
        }
        //Selection sorting ends here
        //Binary search starts here
        else if(r==6)
        {
            int seek;
            struct node *start=head;
            struct node *end=last;
            struct node *trav=start;
            printf("Enter the data you want to search.\n");
            scanf("%d",&seek);
            int count=0;
                int middle=((start->id)+(end->id))/2;
                while(trav->id!=middle)
                {
                    trav=trav->next;
                }
                if(trav->data==seek)
                {
                    printf("The requested data found at ID=%d",trav->id);
                    count++;
                }
                else if(trav->data<seek)
                {
                    start=head;
                    end=trav->prev;
                    binarySearch(start,end,seek);
                    printf("The requested data found at ID=%d",trav->id);
                    count++;
                }
                else
                {
                    start=trav->next;
                    end=last;
                    binarySearch(start,end,seek);
                    printf("The requested data found at ID=%d",trav->id);
                    count++;
                }
            if(count==0)
            {
                printf("Element not found.\n")
            }
        }
        else if(r==7)
        {
            break;
        }
        else
        {
            printf("Invalid Input.\n");
        }
    }
}
