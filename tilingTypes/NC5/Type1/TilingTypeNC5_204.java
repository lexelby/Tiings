package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_204
   extends TilingType
{
   public TilingTypeNC5_204(){
      super( "NC5-204", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 40, 50};
      paramName = new String[]{ "Aspect", "Indent"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 0,4, 1,0,4, 0},
            {1, 0,1, 2,0,1, 1},
      };
      info = "c+d=e\nA=90\nC=2E\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.5;
      double lna = lnt * getParam(paramValues,0)/100;
      double lnb = lnt - lna;

      double dx = lnb * getParam(paramValues,1)/400;
      double k = lna/(lnb-2*dx);

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnb, 0);
      baseTile.setPoint(2,  lnb/2 + dx, (lnb/2 - dx)*k);
      baseTile.setPoint(3,  lnb/2, lna - lnb/2*k);
      baseTile.setPoint(4,  0, lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[1].getX(4);
      offsets[1] = tiles[0].getY(3)-tiles[1].getY(4);
      offsets[2] = tiles[1].getX(3)-tiles[3].getX(2);
      offsets[3] = tiles[1].getY(3)-tiles[3].getY(2);
   }
}
