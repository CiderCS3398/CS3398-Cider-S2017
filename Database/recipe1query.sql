create or replace view Recipe1(Recipe#, Amount Neeeded, Ingredient)
as
select M.TypeOf, R.Amt||' '||R.Measured
from Meats M, Recipes R
where M.FoNo = R.FoNo and R.ReNo = 1
LEFT JOIN
select D.TypeOf, R.Amt||' '||R.Measured
from Dairy D, Recipes R
where D.FoNo = R.FoNo and R.ReNo = 1
LEFT JOIN
select V.TypeOf, R.Amt||' '||R.Measured
from Veggies V, Recipes R
where V.FoNo = R.FoNo and R.ReNo = 1
LEFT JOIN
select G.TypeOf, R.Amt||' '||R.Measured
from Grains G, Recipes R
where G.FoNo = R.FoNo and R.ReNo = 1
LEFT JOIN
select F.TypeOf, R.Amt||' '||R.Measured
from Fruits F, Recipes R
where F.FoNo = R.FoNo and R.ReNo = 1
LEFT JOIN
select H.TypeOf, R.Amt||' '||R.Measured
from Herbs H, Recipes R
where H.FoNo = R.FoNo and R.ReNo = 1
LEFT JOIN
select Dry.TypeOf, R.Amt||' '||R.Measured
from DrySeasonings Dry, Recipes R
where Dry.FoNo = R.FoNo and R.ReNo = 1
LEFT JOIN
select W.TypeOf, R.Amt||' '||R.Measured
from WetSeasonings W, Recipes R
where W.FoNo = R.FoNo and R.ReNo = 1
;
select * from Recipe1;