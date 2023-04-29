import { NativeBaseProvider, extendTheme } from "native-base";

import Routes from "./src/routes";

export default function App() {
  const theme = extendTheme({
    colors: {
      purple: { 900: "#4E0189" },
    },
  });

  return (
    <NativeBaseProvider theme={theme}>
      <Routes />
    </NativeBaseProvider>
  );
}
