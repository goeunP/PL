let rec gcd n m =
	if n>=m then 
		if m=0 then n
		else gcd (n-m) m
	else 
		if n=0 then m
		else gcd (m-n) n ;;
 
let phi n=
  let cnt = ref 0 in
  for i=1 to n do
    if gcd n i=1 then cnt := !cnt+1
  done;
  !cnt ;;

let _ =
  Format.printf "%d\n" (phi 4);
  Format.printf "%d\n" (phi 9);
  Format.printf "%d\n" (phi 10);
  Format.printf "%d\n" (phi 17);
  Format.printf "%d\n" (phi 30)

