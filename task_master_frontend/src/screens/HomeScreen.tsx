import { Box, Heading } from "native-base";

import { ScreenDefault } from "../components/ScreenDefault";
import { Menu } from "../components/Menu";

export function HomeScreen() {
  return (
    <ScreenDefault>
      <Box
        h={150}
        w={150}
        backgroundColor={"blue.600"}
        justifyContent="center"
        p={2}
        borderRadius={160}
      >
        <Heading color={"gray.100"} textAlign="center">
          Fábrica de software
        </Heading>
      </Box>
      <Menu type="normal" />
    </ScreenDefault>
  );
}
