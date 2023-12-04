let print_list list =
  Format.printf("[");
  match list with 
  | [] -> Format.printf "]\n"
  | first :: rest -> 
    let (x, (y, z))= first in Format.printf "(%d, (%d, %d))" x y z ;
    List.iter (fun (x, (y, z)) -> 
      Format.printf "; (%d, (%d, %d))" x y z) rest ;
  Format.printf "]\n" ;;

let prime n=
  let rec prime_loop n cnt=
    if (n > cnt) then
      if (n mod cnt ==0) then
        false
      else 
        prime_loop n (cnt+1)
    else
      true
    in prime_loop n 2 ;;


let goldbach_list_limit lower upper n=
    let rec goldbach_list_rec lower upper n i list=
      if (lower < upper) then
        if (prime (lower-i)==true && (prime i)==true) then
          if (i >= n && lower-i >=n) then
            goldbach_list_rec (lower+1) upper n 2 ((lower, (i, lower-i)) :: list )
          else 
            goldbach_list_rec (lower+1) upper n 2 list 
        else
          goldbach_list_rec lower upper n (i+1) list 
      else
          List.rev list
      in let list=[] in
    goldbach_list_rec lower upper n 2 list;;
      

let _ =
  print_list(goldbach_list_limit 9 20 5);
  print_list(goldbach_list_limit 25 70 10);
  print_list(goldbach_list_limit 100 100 100);
  print_list(goldbach_list_limit 100 200 19);
  print_list(goldbach_list_limit 50 500 20);
  print_list(goldbach_list_limit 1 2000 50)
