/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author user
 */
public class Compare implements Comparator<queue>{
    public int compare(queue d1,queue d2)
    {
        if(d1.cost==d2.cost)
        {
            return 0;
        }
        else if(d1.cost<d2.cost)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}
