import { Box, Divider, Text } from "native-base";
import { Dimensions } from "react-native";
const { width } = Dimensions.get("screen");

export function DividerOR() {
  return (
    <Box
      flexDirection="row"
      alignItems="center"
      justifyContent="flex-start"
      w={width / 2.6}
    >
      <Divider background={"muted.800"} />
      <Text bold mx={5}>
        OU
      </Text>
      <Divider background={"muted.800"} />
    </Box>
  );
}
