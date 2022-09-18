package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_112b
   extends TilingType
{
   public TilingTypeNC5_112b(){
      super( "NC5-112b", 5, SymmetryType.pg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,3,4, 0},

            {0, 1,2, 1,3,4, 1},
            {1, 0,4, 2,3,4, 1},
      };
      info = "a=c=e\nb=c+d\nA=B\nA=E\nD+E=360\n(2B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      final double ln1 = .6;
      double ln2 = ln1 * getParam(paramValues,0)/100;
      double c = ln2/ln1/2;
      double s = Math.sqrt(1-c*c);

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, ln1+ln2,  0);
      baseTile.setPoint(2, ln1*(1-c)+ln2, ln1*s);
      baseTile.setPoint(3, (ln1+ln2)*(1-c), (ln1-ln2)*s);
      baseTile.setPoint(4, ln1*c, ln1*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[3].getX(3);
      offsets[1] = tiles[0].getY(1)-tiles[3].getY(3);
      offsets[2] = tiles[1].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(2)-tiles[0].getY(0);
   }
}
