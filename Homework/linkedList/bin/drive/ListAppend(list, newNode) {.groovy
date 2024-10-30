  ListAppend(list, newNode) {
        if (list⇢head == null) { // List empty
           list⇢head = newNode
           list⇢tail = newNode
        }
        else{
           list⇢tail⇢next = newNode
           list⇢tail = newNode
        }
     }

     ListPrepend(list, newNode) {
        if (list⇢head == null) { // list empty
           list⇢head = newNode
           list⇢tail = newNode
        }
        else {
           newNode⇢next = list⇢head
           list⇢head = newNode
        }
     }