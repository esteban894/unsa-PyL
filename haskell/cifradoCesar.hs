import Data.Char

cifrarChar :: Int -> Char -> Char
cifrarChar 0 c = c
cifrarChar n c
  | isUpper c = chr (mod (ord c - ord 'A' + n) 26 + ord 'A')
  | isLower c = chr (mod (ord c - ord 'a' + n) 26 + ord 'a')
  | otherwise = c

cifradoCesar :: Int -> String -> String
cifradoCesar _ "" = ""
cifradoCesar n str = map (cifrarChar n) str
