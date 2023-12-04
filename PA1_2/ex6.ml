let rec sigma(a, b, f)  =
  if (a<=b) then 
    sigma (a+1, b, f) + (f a)
  else
    0 
  ;;
  

let _ =
  Format.printf "%d\n" (sigma(10, 10, (fun x -> x)));
  Format.printf "%d\n" (sigma(11, 10, (fun x -> x)));
  Format.printf "%d\n" (sigma(10, 5, (fun x -> x)));
  Format.printf "%d\n" (sigma(1, 10, (fun x -> if x mod 2 =0 then 1 else 0)));
  Format.printf "%d\n" (sigma(2, 10, (fun x -> x+10)));
  Format.printf "%d\n" (sigma(0, 100, (fun x -> 0)));
  Format.printf "%d\n" (sigma(10, 12, (fun x -> 2*x)))
