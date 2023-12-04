let print_list list =
  let _ = Format.printf "[" in
  match list with 
  | [] -> Format.printf "]\n"
  | first :: rest -> 
    Format.printf "%d" first ;
    List.iter (fun x -> Format.printf ";%d" x) rest; 
  Format.printf "]\n" ;;

let rec merge list1 list2=
  match (list1, list2) with
  | ([], []) -> []
  | (_ , []) -> list1
  | ([] , _) -> list2
  | (list1_h :: list1_t , list2_h :: list2_t) ->
    if list1_h >= list2_h then 
      list1_h :: merge list1_t list2
    else 
      list2_h :: merge list2_t list1
  ;;


let _ =
  print_list(merge [3;2;1] [5;4]);
  print_list(merge [5;3] [5;2]);
  print_list(merge [4;2] []);
  print_list(merge [] [2;1]);
  print_list(merge [] []);
  print_list(merge [0;0;0;0] [0;0;0;0]);
  print_list(merge [4;3;-2] [9;7;7]);
  print_list(merge [-2;-999] [])

