{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}

{-# HLINT ignore "Use foldr" #-}
import Data.List (transpose)

rellenar :: String -> Int -> String
rellenar str n
  | mod (length str) n == 0 = str
  | otherwise = str ++ replicate tam ' '
  where
    tam = n - mod (length str) n

sToM :: String -> Int -> [String]
sToM [] _ = []
sToM str n = take n str : sToM (drop n str) n

mToS :: [String] -> String
mToS [] = ""
mToS (x : xs) = x ++ mToS xs

cTrans :: String -> Int -> String
cTrans str n = mToS (transpose (sToM (rellenar str n) n))

deco :: String -> Int -> String
deco s n = cTrans s (div (length s) n)