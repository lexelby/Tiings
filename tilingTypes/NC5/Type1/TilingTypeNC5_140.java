package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_140
   extends TilingType
{
   public TilingTypeNC5_140(){
      super( "NC5-140", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 75};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,2, 0,2,3, 0},
            {1, 0,1, 0,0,4, 0},
            {1, 2,0, 2,0,2, 0},
      };
      info = "a=b=d\nA=B\nC+D=180\nD+E=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.7;
      double lnace = lntotal * getParam(paramValues,0)/300;
      double lnb = lntotal - lnace;

      double c = .25;
      double s = Math.sqrt(15./16);

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnace, 0);
      baseTile.setPoint(2,  lnace - c*lnb, s*lnb);
      baseTile.setPoint(3,  lnace - c*(lnb+lnace), s*(lnb-lnace));
      baseTile.setPoint(4,  c*lnace, s*lnace);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[1].getX(0)-tiles[3].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[3].getY(0);
   }
}
