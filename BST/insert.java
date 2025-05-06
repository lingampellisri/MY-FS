class Node 
{
    int val;
    Node left;
    Node right;

    public Node(int val)
    {
        this.val=val;
        left=null;
        right=null;

    }
}


class BST
{


        public static Node insert(Node root,int val)
        {
            if(root==null)
            {
                return new Node(val);
            }

            if(root.val==val)
            return root;

            if(val<root.val)
            {
                root.left=insert(root.left,val);
            }
            else
            {
                root.right=insert(root.right,val);
            }

            return root;
        }

        public static void inorder(Node root)
        {
            if(root==null)
            return ;

            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);

        }

        public static Node insert_Iterative(Node root,int val)
        {
            Node temp=new Node(val);

            if(root==null)
            {
                return temp;
            }

            Node parent=null;
            Node curr=root;


            while(curr!=null)
            {
                parent=curr;

                if(curr.val>val)
                {
                    curr=curr.left;
                }
                else if(curr.val<val)
                {
                    curr=curr.right;
                }else{
                    return root;
                }
            }

            if(parent.val>val)
            {
                parent.left=temp;
            }
            else{
                parent.right=temp;
            }

            return root;
        }


        public static Node search(Node root,int val)
        {
            if(root==null || root.val==val)
            return root;

            if(root.val<val)
            {
                return search(root.right,val);
            }
            else{
                return search(root.left,val);

            }

        }

        public static boolean search_iterative(Node root,int val)
        {
            if(root==null)
            return false;

            Node curr=root;

            while(curr!=null)
            {
                if(curr.val==val)
                return true;
            
            else if(val<curr.val)
            {
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
            }
            return false;


        }

        public static void Preorder(Node root)
        {
            if(root==null)
            return ;

            System.out.print(root.val+" ");
            Preorder(root.left);
             Preorder(root.right);

        }

                public static void Postorder(Node root)
        {
            if(root==null)
            return ;

        
            Postorder(root.left);
             Postorder(root.right);
                 System.out.print(root.val+" ");

        }



    public static void main(String args[])
    {
        Node root=null;

        root = insert(root,50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);
        insert(root,1);

        insert_Iterative(root,11);
         insert_Iterative(root,33);

        inorder(root);
System.out.println();
        Preorder(root);
        System.out.println();
        Postorder(root);


System.out.println();
        System.out.println(search(root,800)!=null ? "Search is found " : "Search is not found");

        
System.out.println();
        System.out.println(search_iterative(root,50) ? "Search is found " : "Search is not found");
    }
}