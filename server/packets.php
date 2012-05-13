<?php
    if (isset($_GET['updateID'])) { $update = $_GET['updateID']; }
    if (isset($_POST['data'])) { $compdata = $_POST['data']; }

    mysql_connect("127.0.0.1","root","crimson");
    mysql_select_db("Food");

function get_json() {
        $sql=mysql_query("select * from WAITING") or die(mqsql_error());    
        while($row=mysql_fetch_assoc($sql)) {
            $output[]=$row;
            break;
        }
        print(json_encode($output));
        mysql_close();
}

    if (!isset($_REQUEST) || empty($_REQUEST)) { get_json(); } 
    
    else {
//Android client received a valid copy of the data
        if (isset($update) && (!isset($compdata))) {            
            //Move row from available packs to backup
            $query = mysql_query("select * from Copy where MATRIX_ID='$update'"); //Verifies that the entry isn't already there.
            if(mysql_num_rows($query)==0) {
                $sql=mysql_query("INSERT INTO Copy (MATRIX, ROWS, COL, ROW_COR, COL_COR, MATRIX_ID)
                            SELECT _ID, ROWS, COL, ROW_COR, COL_COR, MATRIX_ID
                            FROM WAITING WHERE _ID = '$update'") or die(mqsql_error()); 

                if ($sql) { //If copy was successful, remvoe the row from the WAITING table
                    $sql=mysql_query("DELETE FROM WAITING WHERE _ID='$update'") or die(mysql_error());
                }
            }
        }
        
        else if (!isset($update) && (isset($compdata))) {
            $_POST['payload'] = stripslashes($_POST['payload']); //Required if you have magic_quotes on.
            $payload = $_POST['payload'];
            $payloadObj = json_decode($payload); 
   
            /*Check for data, check the sql was good (matrix_ID). Move back to queue
            or delete from copy */
            $check_sql = mysql_query("select * from COMPUTED WHERE MATRIX_ID='$payloadObj->matrix_id' 
and row_cor='$payloadObj->row_cor' and col_cor='$payloadObj->col_cor'");
   $numResults = mysql_num_rows($check_sql);
   if ($numResults >= 1) {
$delete_sql = mysql_query("delete from Copy WHERE MATRIX_ID='$payloadObj->matrix_id' 
and row_cor='$payloadObj->row_cor' and col_cor='$payloadObj->col_cor'");
   } else {
$insert_sql = mysql_query("insert into COMPUTED VALUES (Null,'$payloadObj->data', 
'$payloadObj->matrix_id', '$payloadObj->row_cor', '$payloadObj->col_cor')");
echo json_encode($payloadObj);
   }
        }
        mysql_close();
    }
?>
