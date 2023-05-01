import { VStack, Button, Icon, Text } from "native-base";
import { ColorType } from "native-base/lib/typescript/components/types";
import { ReactNode, useState } from "react";
import { FontAwesome5 } from "@expo/vector-icons";

interface DropDownBoxProps {
  label: string;
  bgColor?: ColorType;
  children: ReactNode;
}

export function DropDownBox({
  label,
  bgColor = "white",
  children,
}: DropDownBoxProps) {
  const [open, setOpen] = useState(false);
  return (
    <>
      <Button
        w={"100%"}
        backgroundColor={bgColor}
        borderWidth={bgColor === "white" ? 2 : 0}
        borderColor="gray.600"
        borderRadius={15}
        py={3}
        zIndex={2}
        rightIcon={
          <Icon
            as={FontAwesome5}
            name={open ? "caret-up" : "caret-down"}
            size="md"
            color={bgColor === "white" ? "gray.600" : "white"}
          />
        }
        onPress={() => setOpen(!open)}
      >
        <Text
          fontSize={"md"}
          bold
          color={bgColor === "white" ? "gray.600" : "white"}
        >
          {label}
        </Text>
      </Button>
      {open && (
        <VStack
          w={"100%"}
          marginTop={-4}
          pt={10}
          px={5}
          py={3}
          space={4}
          borderBottomWidth={2}
          borderLeftWidth={2}
          borderRightWidth={2}
          borderColor="gray.300"
          borderBottomRadius={30}
          backgroundColor="white"
          shadow="7"
        >
          {children}
        </VStack>
      )}
    </>
  );
}
